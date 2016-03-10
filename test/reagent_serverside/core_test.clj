(ns reagent-serverside.core-test
  (:require [clojure.test :refer :all]
            [reagent-serverside.core :refer :all]
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
