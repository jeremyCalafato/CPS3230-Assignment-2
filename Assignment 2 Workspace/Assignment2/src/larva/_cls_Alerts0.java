package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_Alerts0 implements _callable{

public static PrintWriter pw; 
public static _cls_Alerts0 root;

public static LinkedHashMap<_cls_Alerts0,_cls_Alerts0> _cls_Alerts0_instances = new LinkedHashMap<_cls_Alerts0,_cls_Alerts0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\jerem\\Desktop\\University\\Third Year\\Fundamentals of Software Testing\\Assignment 2 Workspace\\Assignment2/src/output_Alerts.txt");

root = new _cls_Alerts0();
_cls_Alerts0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_Alerts0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_Alerts0() {
}

public void initialisation() {
}

public static _cls_Alerts0 _get_cls_Alerts0_inst() { synchronized(_cls_Alerts0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_Alerts0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_Alerts0_instances){
_performLogic_alertUploadAndDelete(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_Alerts0[] a = new _cls_Alerts0[1];
synchronized(_cls_Alerts0_instances){
a = _cls_Alerts0_instances.keySet().toArray(a);}
for (_cls_Alerts0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_Alerts0_instances){
_cls_Alerts0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_alertUploadAndDelete = 104;

public void _performLogic_alertUploadAndDelete(String _info, int... _event) {

_cls_Alerts0.pw.println("[alertUploadAndDelete]AUTOMATON::> alertUploadAndDelete("+") STATE::>"+ _string_alertUploadAndDelete(_state_id_alertUploadAndDelete, 0));
_cls_Alerts0.pw.flush();

if (0==1){}
else if (_state_id_alertUploadAndDelete==102){
		if (1==0){}
		else if ((_occurredEvent(_event,172/*alertsNotDeleted*/))){
		_cls_Alerts0.pw .println ("incorrectlyPopulatedListOfAlerts -> unintentionallyPopulatedListOfAlerts");

		_state_id_alertUploadAndDelete = 98;//moving to state unintentionallyPopulatedListOfAlerts
		_goto_alertUploadAndDelete(_info);
		}
		else if ((_occurredEvent(_event,170/*alertsDeleted*/))){
		_cls_Alerts0.pw .println ("incorrectlyPopulatedListOfAlerts -> emptyListOfAlerts");

		_state_id_alertUploadAndDelete = 99;//moving to state emptyListOfAlerts
		_goto_alertUploadAndDelete(_info);
		}
}
else if (_state_id_alertUploadAndDelete==100){
		if (1==0){}
		else if ((_occurredEvent(_event,162/*unintendedNumberOfAlertsPosted*/))){
		_cls_Alerts0.pw .println ("populatedListOfAlerts -> populatedListOfAlertsContainingUnintendedNumberOfAlerts");

		_state_id_alertUploadAndDelete = 97;//moving to state populatedListOfAlertsContainingUnintendedNumberOfAlerts
		_goto_alertUploadAndDelete(_info);
		}
		else if ((_occurredEvent(_event,164/*intendedNumberOfAlertsPosted*/))){
		_cls_Alerts0.pw .println ("populatedListOfAlerts -> populatedListOfAlertsContainingIntendedNumberOfAlerts");

		_state_id_alertUploadAndDelete = 101;//moving to state populatedListOfAlertsContainingIntendedNumberOfAlerts
		_goto_alertUploadAndDelete(_info);
		}
}
else if (_state_id_alertUploadAndDelete==104){
		if (1==0){}
		else if ((_occurredEvent(_event,158/*unsuccessfullyPostAlerts*/))){
		_cls_Alerts0.pw .println ("viewingAlerts -> unwantedListOfAlerts");

		_state_id_alertUploadAndDelete = 96;//moving to state unwantedListOfAlerts
		_goto_alertUploadAndDelete(_info);
		}
		else if ((_occurredEvent(_event,160/*successfullyPostAlerts*/))){
		_cls_Alerts0.pw .println ("viewingAlerts -> populatedListOfAlerts");

		_state_id_alertUploadAndDelete = 100;//moving to state populatedListOfAlerts
		_goto_alertUploadAndDelete(_info);
		}
}
else if (_state_id_alertUploadAndDelete==103){
		if (1==0){}
		else if ((_occurredEvent(_event,172/*alertsNotDeleted*/))){
		_cls_Alerts0.pw .println ("correctlyPopulatedListOfAlerts -> unintentionallyPopulatedListOfAlerts");

		_state_id_alertUploadAndDelete = 98;//moving to state unintentionallyPopulatedListOfAlerts
		_goto_alertUploadAndDelete(_info);
		}
		else if ((_occurredEvent(_event,170/*alertsDeleted*/))){
		_cls_Alerts0.pw .println ("correctlyPopulatedListOfAlerts -> emptyListOfAlerts");

		_state_id_alertUploadAndDelete = 99;//moving to state emptyListOfAlerts
		_goto_alertUploadAndDelete(_info);
		}
}
else if (_state_id_alertUploadAndDelete==101){
		if (1==0){}
		else if ((_occurredEvent(_event,168/*alertsIncorrectlyPosted*/))){
		_cls_Alerts0.pw .println ("populatedListOfAlertsContainingIntendedNumberOfAlerts -> incorrectlyPopulatedListOfAlerts");

		_state_id_alertUploadAndDelete = 102;//moving to state incorrectlyPopulatedListOfAlerts
		_goto_alertUploadAndDelete(_info);
		}
		else if ((_occurredEvent(_event,166/*alertsCorrectlyPosted*/))){
		_cls_Alerts0.pw .println ("populatedListOfAlertsContainingIntendedNumberOfAlerts -> correctlyPopulatedListOfAlerts");

		_state_id_alertUploadAndDelete = 103;//moving to state correctlyPopulatedListOfAlerts
		_goto_alertUploadAndDelete(_info);
		}
}
}

public void _goto_alertUploadAndDelete(String _info){
_cls_Alerts0.pw.println("[alertUploadAndDelete]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_alertUploadAndDelete(_state_id_alertUploadAndDelete, 1));
_cls_Alerts0.pw.flush();
}

public String _string_alertUploadAndDelete(int _state_id, int _mode){
switch(_state_id){
case 102: if (_mode == 0) return "incorrectlyPopulatedListOfAlerts"; else return "incorrectlyPopulatedListOfAlerts";
case 100: if (_mode == 0) return "populatedListOfAlerts"; else return "populatedListOfAlerts";
case 99: if (_mode == 0) return "emptyListOfAlerts"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  emptyListOfAlerts";
case 98: if (_mode == 0) return "unintentionallyPopulatedListOfAlerts"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  unintentionallyPopulatedListOfAlerts";
case 104: if (_mode == 0) return "viewingAlerts"; else return "viewingAlerts";
case 96: if (_mode == 0) return "unwantedListOfAlerts"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  unwantedListOfAlerts";
case 97: if (_mode == 0) return "populatedListOfAlertsContainingUnintendedNumberOfAlerts"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  populatedListOfAlertsContainingUnintendedNumberOfAlerts";
case 103: if (_mode == 0) return "correctlyPopulatedListOfAlerts"; else return "correctlyPopulatedListOfAlerts";
case 101: if (_mode == 0) return "populatedListOfAlertsContainingIntendedNumberOfAlerts"; else return "populatedListOfAlertsContainingIntendedNumberOfAlerts";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}