"""
自定义日志
"""
import logging
from logging import handlers

log_file = 'db/logs/web.log'

logger = logging.getLogger("web")
logger.setLevel(logging.INFO)
fh = handlers.TimedRotatingFileHandler(filename=log_file, when="midnight")
logger.addHandler(fh)
file_formatter = logging.Formatter(fmt='%(asctime)s %(message)s', datefmt='%Y-%m-%d %H:%M:%S')
fh.setFormatter(file_formatter)
