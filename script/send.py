#! /usr/bin/env python3

from email import encoders
from email.mime.base import MIMEBase
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from smtplib import SMTP_SSL
import getpass
import os
import subprocess
import zipfile


def main():
    FIRST_NAME = input('Παρακαλώ δώστε το μικρό σας όνομα: ')
    LAST_NAME = input('Παρακαλώ δώστε το επώνυμό σας: ')
    AEM = input('Παρακαλώ δώστε το AEM σας: ')
    EMAIL_ADDRESS = input('Παρακαλώ δώστε τη διεύθυνση email σας: ')
    PASSWORD = getpass.getpass(
        'Παρακαλώ δώστε τον κωδικό της διεύθυνσης email σας: '
    )
    SMTP_SERVER = input('Παρακαλώ δώστε τη διεύθυνση του SMTP server σας: ')
    RECIPIENT = input('Παρακαλώ δώστε τη διεύθυνση του παραλήπτη: ')
    BASE_PATH = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    ZIP_NAME = '%s%s_%s.zip' % (FIRST_NAME, LAST_NAME, AEM,)
    ZIP_PATH = os.path.join(
        BASE_PATH, 'dist/%s' % ZIP_NAME
    )


    subprocess.call(
        [
            'zip', '-r', ZIP_PATH,
            os.path.join(BASE_PATH, 'askisi1'),
            os.path.join(BASE_PATH, 'askisi2'),
            os.path.join(BASE_PATH, 'askisi3'),
            os.path.join(BASE_PATH, 'askisi4'),
        ]
    )

    with SMTP_SSL(SMTP_SERVER, port=465) as smtp:
        smtp.login(EMAIL_ADDRESS, PASSWORD)
        message = MIMEMultipart()
        message.preamble = 'CE210 project1 %s' % AEM
        message['Subject'] = 'CE210 project1 %s' % AEM
        message['From'] = EMAIL_ADDRESS
        message['To'] = RECIPIENT
        zip_message = MIMEBase('application', 'zip')

        with open(ZIP_PATH, 'rb') as zip_file:
            zip_message.set_payload(zip_file.read())

        encoders.encode_base64(zip_message)
        zip_message.add_header(
            'Content-Disposition', 'attachment', filename=ZIP_NAME
        )
        message.attach(zip_message)
        message = message.as_string()
        smtp.sendmail(
            EMAIL_ADDRESS, RECIPIENT, message
        )


if (__name__ == '__main__'):
    try:
        main()
    except KeyboardInterrupt:
        print('\nKeyboard interrupt. Exiting.')
