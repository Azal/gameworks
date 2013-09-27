1. ConnectUsers Diagram

There will be a host player, creating the game, setting the preferences and uploading the game to the web. Later, the rest of the players will have to connect to this host and then the match will start. So, first, the host starts a new game. Then, players will join this game via online and the connection will be asking for changes and notifying them via messages.

2. SinglePlayer Diagram

At first, the user has the option to load a previous game state. If not, the Main Module will load a map and get characters from the Scenario Module, get resources from the Resources Module and, finally, get the behaviours from the CharacterBehaviour Module. When all this is set and done our Persitence Module will be autosaving the game state and progress within a time lapse already defined, the Events Module will be sending events to the Scenario Module because of some changes and actions within the game, and the Scenario Module will send a save notification to our Persistence Module so the game will be saved.

3. GamePreview Diagram

The Preview Module will get from different modules all the current variables of the project: map, characters, behaviours and resources. After that, the current state of the project is saved and a preview is displayed to the developer. The events are triggered at any time during the preview.

4. StageCreation Diagram

On first instance, a default map is loaded to start creating a new project. The user is able to edit the map, setting new properties. Also, the user is able to add characters, behaviours and resources. During this process, the Persistence Module saves the current state of the program to prevent crashes.
Finally the user saves the current state of the project.