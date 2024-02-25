#!/bin/bash

strace -o mytrace.txt ./test
grep -c "read" mytrace.txt
grep -c "write" mytrace.txt