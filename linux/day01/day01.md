# Linux

## Agenda
* Operating System
* Linux Introduction
* Shell
* Linux File System Hierarchy
* Absolute Path vs Relative Path
* Basic Linux Commands
    * man
    * pwd
    * cd
    * ls
    * cat
    * mkdir
    * cp
    * mv
    * rm
    * rmdir

## Operating System

### What is OS?
* Interface between Hardware and End user.
* Interface between Hardware and Application programs.
* OS is a resource allocator (for all hardware resources).
* OS is a control program, that controls execution of remaining all programs.
* OS = CD/DVD = Core OS + Applications + Utilities
    * Utilities = e.g. top (task mgr), mkfs (format), fdisk (partitioning), shell (bash, gnome, ...), etc.
    * Applications = Browsers, Media players, Office, Games, Text Editors, etc.
    * Core OS = Kernel

### OS Functions
* Process Management
    * Program: Set of instructions given to the computer. It is an executable file (on storage device).
    * Process: Program under execution (in RAM).
    * Process Management: Process creation, termination, IPC, Threads, Synchronization, etc.
* CPU Scheduling
    * Allocate CPU time to processes/threads.
    * Scheduling types: Pre-emptive scheduling, Non-preemptive scheduling
    * Scheduling algorithms: FCFS, SJF, RR, Priority scheduling
* Memory Management
    * Memory is shared among all running processes.
    * CPU --VA--> MMU --PA--> RAM
    * Memory Management Techniques: Contiguous allocation, Segmentation, Paging.
    * Virtual Memory: Swap area (Inactive processes temp stored in swap partition/file).
* File & IO Management
    * File = Collection of data and information on storage device.
        * Data = Contents, Information = Metadata
        * Data -- Stored in data blocks in File System
        * Metadata -- Stored in i-nodes in in File System
    * File System = Organization of files in the storage device
        * Logically divided in four parts: Boot block, Super block, Inode list, Data blocks
        * File system created during formatting (Linux command: mkfs)
    * Partition a.k.a. Drive = Logical division of disk
        * Partitioning Method1: MBR (Master Boot Record)
            * Maximum 4 partitions -- Called as "Primary" Partitions
            * If need more partitions, make one of the Primary partition as "Extended", and create multiple "Logical" partitions in it.
        * Partitioning Method2: GPT (GUID Partition Table)
            * Maximum 128 partition -- All are "Primary" Partitions
* Hardware abstraction
    * Hide hardware intricasies from end user/application programs
* Networking
    * Data communication across multiple computers in the network.
    * Types: LAN, MAN, WAN
* Security
    * Protection from internal threats e.g. One process access memory of other, ...
    * Security from external threats e.g. Virus, Malware, ...
* User Interfacing
    * Interaction between kernel and end-user -- with a special program -- Shell.

### Shell
* Shell is command interpreter i.e. inputs command from end user and get it executed by OS (kernel).
* Types of shell
    * GUI shell
        * e.g. Windows: explorer.exe (Aero)
        * e.g. Linux: GNOME, KDE
    * CLI shell
        * e.g. Windows: cmd.exe (Command Prompt), powershell
        * e.g. Linux: bash*, ksh, csh, zsh, ...
* Terminals
    * Real terminal -- tty1, tty2, ..., tty6
    * Pseudo terminal -- pts/0, pts/1, ...
    * Linux command -- "tty"
* Currently Logged in users -- Commands:
    * whoami
    * who am i
    * who

### Windows File System Hierarchy
* This PC
    * A: Earlier was used for Floppy drive (1.44 MB)
    * B: Earlier was used for Floppy drive (2.44 MB)
    * C:
        * Windows -- OS all system files (e.g. Kernel=ntoskrnl.exe, Drivers=*.sys, ... )
        * Program Files -- Installed programs (64-bit)
        * Program Files (x86) -- Installed programs (32-bit)
        * Users -- Profiles of all users
            * User1 <-- User Profile
                * Desktop
                * Downloads
                * Documents
                * Music
                * Pictures
            * User2
                * ...
    * D:
        * ...

### Linux File System Hierarchy
* / (root of filesystem)
    * bin -- binaries i.e. executable programs/commands
    * sbin -- system binaries i.e. executable programs/commands for admin
    * lib -- libraries (.so) and drivers (.ko)
    * boot -- bootloader (grub), kernel (vmlinuz)
    * usr -- installed programs
    * var -- system logs, databases data, web server root, ...
    * home -- home directories of all users
        * user1 -- HOME of the user
            * Desktop
            * Downloads
            * Documents
            * Music
            * Pictures
            * ..
        * user2
            * ...
    * root -- home directory for root/super-user/admin user
    * etc -- application config files
    * proc -- processes/kernel/system information
    * sys -- kernel system files
    * dev -- device files
    * tmp -- temp file system (all files auto deleted on shutdown)

### Absolute and Relative Path
```
/
|- home
    |- sunbeam
        |- songs
        |- movies
            |- hollywood
                |- fh.txt
            |- bollywood
```
* Absolute Path: /home/sunbeam/movies/hollywood/fh.txt
* Relative Path w.r.t. sunbeam: movies/hollywood/fh.txt
* Relative Path w.r.t. hollywood: fh.txt
* Relative Path w.r.t. bollywood: ../hollywood/fh.txt

### Special directories
* .     -- current directory
* ..    -- parent directory
* ~     -- user's home directory

### Linux Commands
* pwd
    * by default -- in home directory e.g. /home/sunbeam
* mkdir dirpath
    * mkdir /home/sunbeam/movies
    * mkdir songs
    * mkdir /home/sunbeam/movies/hollywood
    * mkdir movies/bollywood
* ls dirpath
    * ls --> show contents of current directory
    * ls dirpath --> show contents of given directory
        * ls /
        * ls /home
        * ls /home/sunbeam/songs
        * ls movies
* cd dirpath
    * change directory to given path.
    * cd songs
    * pwd
    * cd ..
    * pwd
    * cd /home/sunbeam/movies/bollywood
    * pwd
    * cd ../hollywood
    * pwd
    * Ensure that you are in "hollywood" directory before giving further commands.
* cat > filepath
    * To create a new file.
    * Type file contents and Press Ctrl+D to end.
    * cat > fh.txt
    * ls
* cat filepath
    * cat fh.txt
    * cat /home/sunbeam/movies/hollywood/fh.txt
* cp srcpath destpath
    * cp fh.txt temp.txt
    * ls
    * cat temp.txt
    * cp -r /home/sunbeam/movies /tmp
    * ls /tmp
    * ls /tmp/movies
    * ls /tmp/movies/hollywood
    * cp fh.txt /tmp
    * ls /tmp
    * cat /tmp/fh.txt
* mv srcpath destpath
    * mv fh.txt /home/sunbeam/songs
    * ls
    * ls /home/sunbeam/songs
    * mv /home/sunbeam/songs /tmp
    * ls /home/sunbeam
    * ls /tmp
    * ls
    * mv temp.txt test.txt
        * rename the file from temp.txt to test.txt
    * ls
    * cat test.txt
    * mv test.txt .test.txt
        * rename file to prefix with .
        * it hides the file
    * ls
    * ls -a
    * mv .test.txt test.txt
    * ls
* rmdir dirpath
    * to delete empty directory
    * mkdir hello
    * ls
    * rmdir hello
    * ls
* rm path
    * ls /tmp
    * rm /tmp/fh.txt
    * ls /tmp
    * rm -r /tmp/movies
    * ls /tmp
* man command
