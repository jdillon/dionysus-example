---
title: Syntax
subtitle: Supported markdown syntax
glyph: fas fa-vial

date: 2018-07-06T13:44:46-07:00
draft: false

menu:
  topnav:
    identifier: Syntax
---

# Normal

Foo was here.

# Emphasis

*italic*
_italic_

# Strong

**bold**
__foo__

# Other

~~strikethrough~~

"Hugo"

# Lists

## Unordered

* a
* b
* c

## Unordered (variant)

- e
- f
- g

## Ordered

1. one
1. two
1. three

# H-lines

* * *
***
****

# Refs

[Google][1]

See footnote.[^1]

# Def Lists

Cat
: Fluffy animal everyone likes

Internet
: Vector of transmission for pictures of cats

# Quote

>
> Foo was here.
>

# Code

```xml
<settings> 
  <here foo="bar"/>
</settings>
```

`
<settings> 
  <here foo="bar"/>
</settings>
`

    <settings> 
      <here foo="bar"/>
    </settings>

{{<highlight xml "linenos=table">}}
    <settings> 
      <here foo="bar"/>
    </settings>
{{</highlight>}}

# Tables

   Name | Age
--------|------
    Bob | 27
  Alice | 23

# Emoji

:smile:

[1]: http://google.com/        "Google"

[^1]: Blah blah blah