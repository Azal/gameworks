echo "Hello";
confirmation="0"
# while true; do
#     read -p "Are you sure you want to push to master? (y/n) : " yn
#     case $yn in
#         [Yy]* ) confirmation=1; break;;
#         [Nn]* ) confirmation=0; break;;
#         * ) echo "Please answer yes or no.";;
#     esac
# done
read -p "Are you sure you want to push to master? (y/n) : " confirmation
echo "Pre-Commit Message $confirmation";
exit
echo "Pre-Commit Message2"; 

