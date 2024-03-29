#!/bin/bash
readonly service_name=i113_panda
readonly service_image_name=panda-server

echo $service_name
echo $service_image_name

docker --version

if docker ps | grep -- $service_name > /dev/null
then
docker stop $service_name
docker rm $service_name
docker rmi $service_image_name
else
echo no such container
fi