confirmation="0"
branch=$(echo "$(git symbolic-ref HEAD 2>/dev/null)")
if [ $branch == "refs/heads/master" ]
then
  confirmation=1;
fi
if [ $confirmation == 1 ]
then
    if [ -f i_want_to_commit_to_master ]
    then
      rm i_want_to_commit_to_master
      exit 0
    else
      echo "This is the 'master' branch. Only the dictator is allowed to work here.";
      echo "Remember to create file 'touch i_want_to_commit_to_master' to commit to master"
    fi
    exit 1
fi
# echo "Pre-Commit Message $confirmation";
exit

