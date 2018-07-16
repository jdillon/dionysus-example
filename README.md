# Hugo Dionysus Theme Example

Example project using Hugo Dionysus Theme for building project sites.

## Requirements

* Apache Maven 3.3+ (prefer to use included `mvnw`)
* JDK 7+ (10 is **NOT** supported)
* [Hugo Dionysus Theme](https://github.com/jdillon/hugo-dionysus-theme)

[Hugo](https://gohugo.io/getting-started/installing/) is needed, but the maven integration will provide this if
not otherwise configured explicitly.

### Build

    ./mvnw clean install

## Site 

To keep things simple for production and development, build will write files into the `src/site/hugo` directory.
 
### Setup

**TODO** make a goal to automate this first-time setup

Prepare `gh-pages` branch:

    git@github.com:jdillon/dionysus-example.git gh-pages
    cd gh-pages
    git co --orphan gh-pages
    rm -rf * .gitignore
    touch index.html
    git add index.html
    git ci -a -m "initial"
    git push origin gh-pages

### Development

* [Development](src/site/hugo/README.md)

### Building

    ./mvnw clean install dionysus:build
    
### Publishing

    ./mvnw dionysus:publish

