__config() -> {

};

_getProfession() -> (
    villagerData = query(global_entity, 'nbt', 'VillagerData.profession');
    profession = replace(villagerData, 'minecraft:');
    run('/tellraw '+player()+' ["",{"text":"Profession: ","color":"aqua"},{"text":"'+profession+'.","color":"white"}]');
    canpickuploot =query(global_entity, 'nbt', 'CanPickUpLoot');
    if(canpickuploot == true, 
    run('/tellraw '+player()+' ["",{"text":"CanPickUpLoot: ","color":"aqua"},{"text":"Yes.","color":"white"}]');
    );
);

_exception() -> (
    run('/tellraw '+player()+' {"text":"Apunta al aldeano, cabeza de brócoli.","color":"dark_red"}');
);

__command() -> (
    global_entity = query(player(), 'trace', 4.5, 'entities');
    if((global_entity == 'Zombie Villager'), _getProfession(), _excepcion());
    return;
);