package aspects;

import larva.*;
public aspect _asp_uploadAlerts0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_uploadAlerts0.initialize();
}
}
before () : (call(* *.successfullyPostAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_uploadAlerts0.lock){

_cls_uploadAlerts0 _cls_inst = _cls_uploadAlerts0._get_cls_uploadAlerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 368/*successfullyPostAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 368/*successfullyPostAlerts*/);
}
}
before () : (call(* *.alertsIncorrectlyPosted(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_uploadAlerts0.lock){

_cls_uploadAlerts0 _cls_inst = _cls_uploadAlerts0._get_cls_uploadAlerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 376/*alertsIncorrectlyPosted*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 376/*alertsIncorrectlyPosted*/);
}
}
before () : (call(* *.unintendedNumberOfAlertsPosted(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_uploadAlerts0.lock){

_cls_uploadAlerts0 _cls_inst = _cls_uploadAlerts0._get_cls_uploadAlerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 370/*unintendedNumberOfAlertsPosted*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 370/*unintendedNumberOfAlertsPosted*/);
}
}
before () : (call(* *.alertsDeleted(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_uploadAlerts0.lock){

_cls_uploadAlerts0 _cls_inst = _cls_uploadAlerts0._get_cls_uploadAlerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 378/*alertsDeleted*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 378/*alertsDeleted*/);
}
}
before () : (call(* *.intendedNumberOfAlertsPosted(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_uploadAlerts0.lock){

_cls_uploadAlerts0 _cls_inst = _cls_uploadAlerts0._get_cls_uploadAlerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 372/*intendedNumberOfAlertsPosted*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 372/*intendedNumberOfAlertsPosted*/);
}
}
before () : (call(* *.unsuccessfullyPostAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_uploadAlerts0.lock){

_cls_uploadAlerts0 _cls_inst = _cls_uploadAlerts0._get_cls_uploadAlerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 366/*unsuccessfullyPostAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 366/*unsuccessfullyPostAlerts*/);
}
}
before () : (call(* *.alertsCorrectlyPosted(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_uploadAlerts0.lock){

_cls_uploadAlerts0 _cls_inst = _cls_uploadAlerts0._get_cls_uploadAlerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 374/*alertsCorrectlyPosted*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 374/*alertsCorrectlyPosted*/);
}
}
before () : (call(* *.alertsNotDeleted(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_uploadAlerts0.lock){

_cls_uploadAlerts0 _cls_inst = _cls_uploadAlerts0._get_cls_uploadAlerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 380/*alertsNotDeleted*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 380/*alertsNotDeleted*/);
}
}
}