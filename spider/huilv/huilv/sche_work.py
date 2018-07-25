import schedule
import time
import subprocess
def job():
    subprocess.Popen('scrapy crawl huilv')

def count1():
    print(1);
schedule.every(2).minutes.do(job)
schedule.every(1).seconds.do(count1)

while True:
    schedule.run_pending()
    time.sleep(1)