#!/usr/bin/python3
import sys
import time

for line in sys.stdin:
    words = line.split()
    time.sleep(1)
    for word in words:
        print(f"{word}\t1")

