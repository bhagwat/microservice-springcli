#!/usr/bin/env bash

curl -X POST \
     -d "client_id=my-client" \
	 -d "client_secret=my-client-secret" \
     -d "grant_type=password" \
	 -d username=bhagwat.kumar@tothenew.com \
	 -d password=123456	\
     -d "scope=read" http://localhost:9999/oauth/token