(ns hammer.core-spec
   (:use
    [clojure.test :only [deftest is are testing]]
        hammer.core))
(def a-test-template
     "<div>
	%%(str \"hello punit\")%% %%(str \"hello punit\")%%
	<div class=\"test\">
		%%(+ 1 2)%%
	</div>
</div>")

(deftest test-split-template-into-array
  (testing "if the regex splits the template into the correct array"
    (are (= _1 _2)
         a-test-template  (eval-template "<div>\nhello punit hello punit\n<div class=\"test\">\n3\n</div>\n</div>\n"))))
