Gameworks (Games + Framework)
=============================

## Introduction

The Gameworks framework allows you to create java game applications in a quick and easy way. The main target is the creation of 2D games, with the focus on RPG genre. It provides a lot of classes and functions, which makes it easy for starter java programmers to develop awesome game projects from scratch.
This project will finally be available as an Eclipse plug-in. More to come.

### Installation

To clone the project start with:

	git clone https://github.com/maxfindel/gameworks

If you don't have permission to write, send an email to the owner([max@findel.cl](mailto:max@findel.cl)).  
Then start an Eclipse Java Project with this folder as root and you are good to go.

The first thing you need to do once you cloned the project is:

	cd gameworks
	cp ./pre-commit.sh .git/hooks/pre-commit
This will prevent casual pushes to the **master** branch. 

Now, go to your groups branch with:

	git checkout groupX/master

***Always*** pull changes before doing any work:

	git pull origin groupX/master
	git pull origin master
	/* If there are any changes or updates you want to push: */
	git push origin groupX/master


### Oficial Documents
[G+ Community](https://plus.google.com/communities/107638331003604365607) - The **oficial** community and communication way.  
[Codification Standard](https://docs.google.com/document/d/1I_9CAdi5IocV03Z_EkPQFpNvF4ElPkB1GibfhFCLJSI/edit?hl=es-419&forcehl=1) - How to write code when working on this project.  
[Modules' Overview](https://docs.google.com/document/d/1m7EfpFAl9fo-AB1Bv2Gl3hi68soGBCxONnmcXbIKuLc/edit?usp=sharing) - Shows on what everyone will be working.  
[Users Info](https://docs.google.com/forms/d/1QtkXnSQXjXHQgoak7EcNlUq2M_GFHQws0GqxbSG0eJI/viewform) - Information about the students working on the project. Please do fill.  
<!-- [(NOT) Public Information](https://docs.google.com/spreadsheet/ccc?key=0Am_s2HenpOt6dEFhVGZjZGZhWkM0N2xySTBDd0tOYUE#gid=0)  -->

### Useful links
[Git Merging & Branching](http://git-scm.com/book/en/Git-Branching-Basic-Branching-and-Merging) - Lear the basics of branches and mixes before getting started  
[BrainBash(ßeta)](https://github.com/maxfindel/brainBash) - A Unix-Console helper for Github and other platforms.


### Teams

* **Git Dictator:** Max Findel
* **Community:** Nikolas Bravo, Ignacio Carmach
* **Groups and assignments:**
	- *Group 1:* Preview 
	- *Group 2:* Resources 
	- *Group 3:* Character behaviour 
	- *Group 4:* Events 
	- *Group 5:* Scenery creation: maps, characters, items / inanimated objects, story 
	- *Group 6:* Input/Output 
	- *Group 7:* Persistency (game state) 
	- ***Group 8:* Conectivity / Network** 

####Git Branches
master -> Only for dictator. Always stable.  
groupX/master -> Stable branch for each group.  
groupX/other -> You can work on any other branch you like.  

##Credits & Licence

All your base(codes) are belong to us!
