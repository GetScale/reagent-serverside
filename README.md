# reagent-serverside

A Clojure library designed to render reagent components on the server for
improved proformance. This library is meant to only render the most basic of
reagent right now.

[![Clojars Project](https://clojars.org/getscale/reagent-serverside/latest-version.svg)](https://clojars.org/getscale/reagent-serverside)

## Usage

You need to write your components in cljc so both cljs and clj can access them.
If you need to do something that only cljs can do try using a reader
conditional.

This library produces hiccup code so you can easily stick this in place of the
blank mount point for reagent.

```clojure
(def mount
 [:div#app (render-page home-page)])
```

After you have put this in your server code, I reccomend testing it out and
checking the client for any react `console.warning`'s

## License

The MIT License (MIT)

Copyright (c) 2016 Alex Bierwagen

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
