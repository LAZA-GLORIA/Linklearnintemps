function deuxChiffres(num)
{
    return num<10 ? "0"+num : num;
}

function formatDuree(duree, def='') {
    if(isNaN(duree))
        return def;

    return Math.floor(duree/(24*3600))+"j "
            +Math.floor(duree/3600)%24+":"
            +deuxChiffres(Math.floor(duree/60)%60)+"'"
            +deuxChiffres(Math.floor(duree)%60)+"\"";
}

function maintenant() {
    return Math.round(Date.now()/1000);
}