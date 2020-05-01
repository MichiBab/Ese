#include "Broker.hpp"

Broker* Broker::pointer_Instance = NULL;

Broker* Broker::getInstance(){
   if (!pointer_Instance)   // Only allow one instance of class to be generated.
      pointer_Instance = new Broker;
   return pointer_Instance;
}