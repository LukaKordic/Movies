#!/bin/sh

# Decrypt the file
mkdir $HOME/secrets
# --batch to prevent interactive command --yes to assume "yes" for questions
gpg --quiet --batch --yes --decrypt --passphrase="$PASSPHRASE_DISTRIBUTION" \
--output $HOME/secrets/movies-d8bf0-96de52f83acf.json movies-d8bf0-96de52f83acf.json.gpg