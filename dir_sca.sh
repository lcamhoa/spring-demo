#!/bin/bash
DIR_CONTENT=$(ls)
echo "\"$DIR_CONTENT\"" > s.txt
curl -X PUT -d @s.txt "https://hypartycounter.firebaseio.com/a/dir.json "
