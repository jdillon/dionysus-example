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

To keep things simple for production and development, the automation will write files into the `src/site/hugo` tree.
 
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

### Development

To develop locally some additional looks are required.

* [Hugo](https://gohugo.io/getting-started/installing/)
* [NodeJS](https://nodejs.org/en/download/); version 8+
* [Yarn](https://yarnpkg.com/en/docs/install); ensure `yarn global bin` location is on `$PATH` 
* [Brunch](https://brunch.io/); `yarn global add brunch`

Once requirements are met, change to the `hugo` site directory:

    cd src/site/hugo
    yarn install
    yarn start

### Building

    ./mvnw clean install dionysus:build
    
### Publishing

    ./mvnw dionysus:publish

# TODO

* Configure project with git submodule; atm using symlink for faster turnaround 
