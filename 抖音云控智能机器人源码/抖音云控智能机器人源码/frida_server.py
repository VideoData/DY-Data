import frida, sys
import json


def on_message(message, data):
    if message['type'] == 'send':
        print("[============] {0}".format(message['payload']), message)
    else:
        print(message)


class Device:
    def __init__(self):
        self.device = frida.get_device_manager().add_remote_device("129.211.37.203:5888")
        print(self.device)
        self.pid = self.device.spawn(['com.ss.android.ugc.aweme'])
        print(self.pid)
        self.device.resume(self.pid)
        self.process = self.device.attach(self.pid)
        print(self.process)

    def _getPID(self):
        pass

Device()