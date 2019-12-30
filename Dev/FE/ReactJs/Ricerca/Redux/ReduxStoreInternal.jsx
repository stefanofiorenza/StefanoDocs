const store= function(reducer){
  
  var state;
  var listeners=[];
  
  
  const getState= function(){
    return state;
  }
  
  const dispatch= function(action){
    state=reducer(state, action);
    for (listener : listeners){
      listener(action);
    }
  }
  
  const subscribe= function(listener){
    listeners.push(listener);
    
    // function che si puo' chiamare per unsubscribe
    return function(){
      
      /*
      for (i=0< listeners.length; i++){
        if(listeners[i]==listener){
          listeners.remove(i);
        }
      }
      */
      
      //o piu sinteticamente: filtra tenendo solo quelli diversi da listener      
      listeners=listeners.filter( lst => lst!=listener);
    }
  }  
};