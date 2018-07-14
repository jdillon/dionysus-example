# Hugo Dionysus Theme Example

Example project using Hugo Dionysus Theme for building project sites.

## Requirements

* Apache Maven 3.3+ (prefer to use included `mvnw`)
* JDK 7+ (10 is **NOT** supported)
* [Hugo](https://gohugo.io/getting-started/installing/)
* [Hugo Dionysus Theme](https://github.com/jdillon/hugo-dionysus-theme)

### Build

    ./mvnw clean install

## Site 

### Setup

Prepare `gh-pages` branch:

    git@github.com:jdillon/dionysus-example.git gh-pages
    cd gh-pages
    git co --orphan gh-pages
    rm -rf * .gitignore
    touch index.html
    git add index.html
    git ci -a -m "initial"
    git push origin gh-pages

### Building

    ./mvnw clean install dionysus:build
    
### Publishing

    ./mvnw dionysus:publish

# TODO

* Configure project with git submodule; atm using symlink for faster turnaround 
