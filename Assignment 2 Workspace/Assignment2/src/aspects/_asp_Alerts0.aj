package aspects;

import larva.*;
public aspect _asp_Alerts0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_Alerts0.initialize();
}
}
before () : (call(* *.successfullyPostAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 160/*successfullyPostAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 160/*successfullyPostAlerts*/);
}
}
before () : (call(* *.alertsIncorrectlyPosted(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 168/*alertsIncorrectlyPosted*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 168/*alertsIncorrectlyPosted*/);
}
}
before () : (call(* *.unintendedNumberOfAlertsPosted(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 162/*unintendedNumberOfAlertsPosted*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 162/*unintendedNumberOfAlertsPosted*/);
}
}
before () : (call(* *.alertsDeleted(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 170/*alertsDeleted*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 170/*alertsDeleted*/);
}
}
before () : (call(* *.intendedNumberOfAlertsPosted(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 164/*intendedNumberOfAlertsPosted*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 164/*intendedNumberOfAlertsPosted*/);
}
}
before () : (call(* *.unsuccessfullyPostAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 158/*unsuccessfullyPostAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 158/*unsuccessfullyPostAlerts*/);
}
}
before () : (call(* *.alertsCorrectlyPosted(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 166/*alertsCorrectlyPosted*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 166/*alertsCorrectlyPosted*/);
}
}
before () : (call(* *.alertsNotDeleted(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 172/*alertsNotDeleted*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 172/*alertsNotDeleted*/);
}
}
}