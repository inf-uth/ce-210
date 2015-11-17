#! /usr/bin/env python

"""
Simple server scripts that spawns the Jupyter notebook server process.
"""

import os
import subprocess

# Check if code runs in SourceLair and change current directory to project
# root directory, if so.
if (os.environ.get('SL_ENV') == '1'):
    os.chdir('/mnt/project')

# Try to import jupyter. If this fails, install dependencies.
try:
    import jupyter
except ImportError:
    print 'Could not find jupyter. Installing dependencies...'
    subprocess.call(['pip', 'install', '-r', 'requirements.txt'])


subprocess.call([
    'jupyter', 'notebook', '--no-browser', '--ip=0.0.0.0', '--port=5000'
])
