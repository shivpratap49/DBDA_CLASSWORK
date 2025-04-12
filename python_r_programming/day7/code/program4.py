# process
# - running instance of a program
# - program: set of instructions stored in a file on disk
# - uses Process Control Block (PCB)
#   - which contains all the information about the process
#   - which includes pid (process Id), process name etc.
# - program can stored on the disk but has to be loaded in
#   memory for execution
# - program can NOT be executed on the disk

# thread
# - execution unit of process
# - OS feature for asynchronous programming
# - every process must contain at least one thread
# - used for parallel / asynchronous code execution
# - all threads within a process shares the code section
# - types processes
#   - single threaded process (there is only one thread)
#   - multi threaded process (there are more than 1 threads)

# code section / code region
# - the memory where the program's code gets loaded
# - shared with the process(es)

# data segment
# - contains the global and static variables

# stack
# - memory required to stack frames (function activation records)
# - every stack frame contains the function's local variables and parameters
# - when function exits, the stack frame gets destroyed
# - has a limit (it can NOT grow indefinitely)

# heap memory
# - dynamic memory
# - used to store the objects created in the programs
# - unlimited memory

# registers
# - static memory added inside the processors
# - e.g. A, B, C etc.
# - state of the registers at the time the process is getting executed

# memory hierarchy
# - static memory
#   - registers inside CPU
#   - L1, L2 and L3 cache
# - dynamic memory
#   - primary memory (RAM)
# - second storage
#   - SSD (electronic)
#   - HDD (magnetic)
#   - external

import time
import threading


def print_numbers():
    for i in range(10):
        print(f"number = {i}")
        time.sleep(1)


def print_characters():
    for ch in "abcdefgh":
        print(f"ch = {ch}")
        time.sleep(1)


# save the current time in milliseconds
start_time = time.time()

# sequential / synchronous execution of code
# print_numbers()
# print_characters()

# asynchronous execution of the code
t1 = threading.Thread(target=print_numbers)
t2 = threading.Thread(target=print_characters)

# start the threads
t1.start()
t2.start()

# wait till both the threads are executing
t1.join()
t2.join()

# get the current time and find the difference
stop_time = time.time()
print(f"total time taken = {stop_time - start_time}")