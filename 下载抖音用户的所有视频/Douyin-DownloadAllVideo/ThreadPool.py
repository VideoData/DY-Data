import queue
import threading


class ThreadPool(object):
    def __init__(self, max_workers):
        self.queue = queue.Queue()
        self.workers = [threading.Thread(target=self._worker) for _ in range(max_workers)]

    def start(self):
        for worker in self.workers:
            worker.start()

    def stop(self):
        for _ in range(len(self.workers)):
            self.queue.put(None)
        for worker in self.workers:
            worker.join()

    def submit(self, job):
        self.queue.put(job)

    def _worker(self):
        while True:
            job = self.queue.get()
            if job is None:
                break
            job()
