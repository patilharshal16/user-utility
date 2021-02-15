#!/bin/sh

curl --location --request POST 'http://localhost:8180/api/ebi/user/add' \
--header 'Content-Type: application/json' \
--data-raw '{
"first_name": "John",
"last_name": "Keynes",
"age": "29",
"favourite_colour": "red"
}'