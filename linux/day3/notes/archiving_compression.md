# file navigation

```bash

# go to home directory
> cd ~
> cd $HOME

# go to the last directory
> cd -

```

# archiving

```bash

# archive the files
# > tar -cvf <tar file name> <list of files or directories to be archived>
> tar -cvf myfiles.tar file*

# check the contents of a tar file
# > tar -tvf <tar file name>
> tar -tvf myfiles.tar

# extract the contents from tar file
# > tar -xvf <tar file name>
> tar -xvf myfiles.tar

```

# compression

## gzip

```bash

# compress the file
# this will delete the original file and will replace it with compressed one
# > gzip <file to be compressed>
> gzip myfiles.tar

# compress the file by keeping the original one
# > gzip -k <file to be compressed>
> gzip -k myfiles.tar

# decompress the file
# > gzip <compressed file>
> gzip -d myfiles.tar.gz

```

## bzip2

```bash

# compress the file
# > bzip2 -z <file to be compressed>
> bzip2 -z myfiles.tar

# decompress the file
# > bzip2 -d <compressed file>
> bzip2 -d myfiles.tar.bz2

```

# archive and compression

```bash

# archive the files and compress using gzip
# > tar -czvf <compressed archived file> <file(s) to be archived and compressed>
> tar -czvf myfiles.tar.gz files*

# archive the files and compress using bzip2
# > tar -cjvf <compressed archived file> <file(s) to be archived and compressed>
> tar -cjvf myfiles.tar.bz2 files*

```

# decompression and unarchive

```bash

# decompress using gzip and unarchive the files
# > tar -xzvf <gzipped file>
> tar -xzvf myfiles.tar.gz

# decompress using bzip2 and unarchive the files
# > tar -xjvf <compressed archived file>
> tar -xjvf myfiles.tar.bz2

```
