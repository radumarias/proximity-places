#!/bin/bash
# @author bp

set -e

echo -e "\n\e[1m Generating Compile Report in Development Mode\e[0m\n This shouldn't take more than 10 seconds...\n" 
mvn gwt:compile -P"development-compile-report" -Dalt.build.dir=target/ -DskipTests

echo -e "\n"
read -p " Would you like to view the compile report index.html page in your browser? (y/n) " -n 1 -r
echo -e "\n"
if [[ $REPLY =~ ^[Yy]$ ]]; then
gnome-open target/extra/ProximityPlaces/soycReport/compile-report/index.html
else
echo -e "\n Just in case you change your mind, you may find the compile report@\e[92m target/extra/ProximityPlaces/compile-report/ \e[39m"
echo -e "\n"
exit 1
fi
