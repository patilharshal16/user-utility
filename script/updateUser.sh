#!/bin/sh

curl --location --request PUT 'http://localhost:8180/api/ebi/user/update/1' \
--header 'Content-Type: application/json' \
--data-raw '{
"first_name": "Harshal",
"last_name": "Patil",
"age": "30",
"favourite_colour": "red"
}'