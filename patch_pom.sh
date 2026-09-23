sed -i '' -e '/<plugins>/ a\
      <plugin>\
        <groupId>com.diffplug.spotless</groupId>\
        <artifactId>spotless-maven-plugin</artifactId>\
        <version>2.43.0</version>\
        <configuration>\
          <java>\
            <googleJavaFormat>\
              <version>1.22.0</version>\
              <style>AOSP</style>\
              <reflowLongStrings>true</reflowLongStrings>\
            </googleJavaFormat>\
            <removeUnusedImports />\
            <formatAnnotations />\
          </java>\
        </configuration>\
      </plugin>' pom.xml
