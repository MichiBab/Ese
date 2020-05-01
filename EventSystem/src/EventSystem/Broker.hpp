#if !defined(BrokerHeader_h)
#define BrokerHeader_h
#include <stddef.h>
#include "EnumDummy.hpp"

class Broker
{
private:
    //For Singleton Desing Pattern  
    Broker(){}; // Private so that it can  not be called
	Broker(Broker const&){};             // copy constructor is private
	Broker& operator=(Broker const&){};  // assignment operator is private
	static Broker* pointer_Instance ;
    ~Broker(){};
    
public:
    //For Singleton Desing Pattern
    static Broker* getInstance();


};





#endif // MACRO
