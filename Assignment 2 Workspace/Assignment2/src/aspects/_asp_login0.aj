package aspects;

import larva.*;
public aspect _asp_login0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_login0.initialize();
}
}
before () : (call(* *.viewAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_login0.lock){

_cls_login0 _cls_inst = _cls_login0._get_cls_login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 100/*viewAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 100/*viewAlerts*/);
}
}
before () : (call(* *.incorrectLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_login0.lock){

_cls_login0 _cls_inst = _cls_login0._get_cls_login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 98/*incorrectLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 98/*incorrectLogin*/);
}
}
before () : (call(* *.correctLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_login0.lock){

_cls_login0 _cls_inst = _cls_login0._get_cls_login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 96/*correctLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 96/*correctLogin*/);
}
}
before () : (call(* *.logout(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_login0.lock){

_cls_login0 _cls_inst = _cls_login0._get_cls_login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 102/*logout*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 102/*logout*/);
}
}
}