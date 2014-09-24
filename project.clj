(defproject lein-publishers "1.0.13-SNAPSHOT"
  :description "publish to fig using lein"
  :eval-in-leiningen true
  :source-paths ["src"]
  :jar-name "lein-publishers.jar"
  :release-tasks [["clean"]
                  ["check"]
                  ["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ;; ["vcs" "tag"] would like to have this, but it requires we all set up gpg keys to sign tag objects.
                  ["jar"]
                  ["deploy"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]])
