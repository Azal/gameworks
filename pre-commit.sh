confirmation="0"
branch=$(echo "$(git symbolic-ref HEAD 2>/dev/null)")
case $branch in
    ["refs/heads/master"]* ) confirmation=1; break;;
    * ) echo "not-master";;
esac
if [ $confirmation == 1 ]
then
    if [ -f i_want_to_commit_to_master ]
    then
      rm i_want_to_commit_to_master
      git rm i_want_to_commit_to_master
      exit 0
    else
      echo "This is the 'master' branch. Only the dictator is allowed to work here.";
      echo "Remember to create file 'touch i_want_to_commit_to_master' to commit to master"
    fi
    exit 1
fi
# echo "Pre-Commit Message $confirmation";
exit

