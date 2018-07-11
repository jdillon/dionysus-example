# Hugo Dionysus Theme Example

Example project using Hugo Dionysus Theme for building project sites.

**FIXME** Adjust for Maven integration

## Requirements

* [NodeJS](https://nodejs.org/en/download/); version 8+
* [Hugo](https://gohugo.io/getting-started/installing/)
* [Hugo Dionysus Theme](https://github.com/jdillon/hugo-dionysus-theme) requirements

## Building

Prepare dependencies:

    yarn install

## Running

Start Hugo (and theme watcher):

    yarn start

and then browse:

* http://localhost:1313/dionysus-example/

# TODO

* Configure project with git submodule; atm using symlink for faster turnaround 

## Setup

Prepare `gh-pages` branch:

    git@github.com:jdillon/dionysus-example.git public
    cd public
    git co --orphan gh-pages
    rm -rf * .gitignore
    touch index.html
    git add index.html
    git ci -a -m "initial"
    git push origin gh-pages
