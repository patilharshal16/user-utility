#!/bin/sh

curl --location --request POST 'http://localhost:8180/api/ebi/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "person": [
{
"first_name": "John",
"last_name": "Keynes",
"age": "29",
"favourite_colour": "red"
},
{
"first_name": "Sarah",
"last_name": "Robinson",
"age": "54",
"favourite_colour": "blue"
}
]
}'