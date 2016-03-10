(ns reagent-serverside.core-test
  (:require [clojure.test :refer :all]
            [reagent-serverside.core :refer [render-page]]
            [hiccup.core :refer [html]]))

(deftest basic-html
  (testing "single tag markup"
    (let [markup [:div "Hi"]]
      (is (= (render-page markup)
             [:div {:data-reactid ".0", :data-react-checksum -1508505091} "Hi"]))))
  (testing "nested tag markup"
    (let [markup [:div [:span "Alex"] [:h2 "Is awesome"]]]
      (is (= (render-page markup)
             [:div {:data-reactid ".0", :data-react-checksum 170992002}
              [:span {:data-reactid ".0.0"} "Alex"]
              [:h2 {:data-reactid ".0.1"} "Is awesome"]])))))

(deftest basic-html-with-attrs
  (testing "single tag markup with attrs"
    (let [markup [:div {:class "red"} "I am red"]]
      (is (= (render-page markup)
             [:div {:class "red", :data-reactid ".0", :data-react-checksum -1785786416} "I am red"]))))
  (testing "nested tag markup with attrs"
    (let [markup [:div {:id "boo"} [:span.name "You"] [:a {:href "https://google.com"} "der googlz"]]]
      (is (= (render-page markup)
             [:div {:id "boo", :data-reactid ".0", :data-react-checksum 1473982692}
              [:span.name {:data-reactid ".0.0"} "You"]
              [:a {:href "https://google.com", :data-reactid ".0.1"} "der googlz"]])))))

(deftest basic-html-with-events
  (testing "single tag with onclick camel-case"
    (let [markup [:a {:onClick #(println "HI")} "Say Hello"]]
      (is (= (render-page markup)
             [:a {:data-reactid ".0", :data-react-checksum -1077146935} "Say Hello"]))))
  (testing "single tag with onclick dash-case"
    (let [markup [:a {:on-click #(println "HI")} "Say Hello"]]
      (is (= (render-page markup)
             [:a {:data-reactid ".0", :data-react-checksum -1077146935} "Say Hello"]))))
  (testing "nested tag with onclick camel-case"
    (let [markup [:div [:a {:onClick #(+ 1 1)} "First grade math is what?"]]]
      (is (= (render-page markup)
             [:div {:data-reactid ".0", :data-react-checksum 890247733}
              [:a {:data-reactid ".0.0"} "First grade math is what?"]]))))
  (testing "nested tag with onclick dash-case"
    (let [markup [:div [:a {:on-click #(+ 1 1)} "First grade math is what?"]]]
      (is (= (render-page markup)
             [:div {:data-reactid ".0", :data-react-checksum 890247733}
              [:a {:data-reactid ".0.0"} "First grade math is what?"]])))))

(deftest basic-html-with-classid
  (testing "single tag with class"
    (let [markup [:div.class "I have class"]]
      (is (= (render-page markup)
             [:div.class {:data-reactid ".0", :data-react-checksum 139399772} "I have class"]))))
  (testing "single tag with id"
    (let [markup [:div#id "tag, your id"]]
      (is (= (render-page markup)
             [:div#id {:data-reactid ".0", :data-react-checksum -1918824501} "tag, your id"]))))
  (testing "nested tag with classes"
    (let [markup [:div.app [:a.github {:href "https://github.com"} "dem g hubs"]]]
      (is (= (render-page markup)
             [:div.app {:data-reactid ".0", :data-react-checksum 731064051}
              [:a.github {:href "https://github.com", :data-reactid ".0.0"} "dem g hubs"]]))))
  (testing "nested tag with ids"
    (let [markup [:div#app [:a#company {:href "http://getscale.com"} "mah birthplace"]]]
      (is (= (render-page markup)
             [:div#app {:data-reactid ".0", :data-react-checksum -34134260}
              [:a#company {:href "http://getscale.com", :data-reactid ".0.0"} "mah birthplace"]])))))

;; (deftest html-list-loops)
;; TODO : for loops with keys for loops
