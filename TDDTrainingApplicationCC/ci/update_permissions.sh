#!/bin/bash
echo "Updating file permissions..."
pwd
ls
find resource-TDD-Training-Application/TDDTrainingApplicationCC -type d -exec chmod go+w {} \;
