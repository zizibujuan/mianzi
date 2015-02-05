# decor-build

Build version of [ibm-js/decor](https://github.com/ibm-js/decor).

## Status

No official release yet.

## Installation

_Bower_ release installation:

    $ bower install decor-build

_Manual_ master installation:

    $ git clone git://github.com/ibm-js/decor-build.git

Then install dependencies with bower (or manually from github if you prefer to):

	$ cd decor-build
	$ bower install


## How to use

To load the minified layer you need to wrap your main `require` call with another `require`, requiring `"decor-build/layer"`. Then you should continue to
refer to modules with `"decor/foo"`.

For example, this code:
```js
require(["app/main", "decor/foo"], function() {
	...
});
```
Becomes:
```js
require(["decor-build/layer"], function() {
	require(["app/main", "decor/foo"], function() {
		...
	});
});
```

## Licensing

This project is distributed by the Dojo Foundation and licensed under the ["New" BSD License](./LICENSE).
All contributions require a [Dojo Foundation CLA](http://dojofoundation.org/about/claForm).
