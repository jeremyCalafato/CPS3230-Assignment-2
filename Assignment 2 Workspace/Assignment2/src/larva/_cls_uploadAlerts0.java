package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_uploadAlerts0 implements _callable{

public static PrintWriter pw; 
public static _cls_uploadAlerts0 root;

public static LinkedHashMap<_cls_uploadAlerts0,_cls_uploadAlerts0> _cls_uploadAlerts0_instances = new LinkedHashMap<_cls_uploadAlerts0,_cls_uploadAlerts0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\jerem\\Desktop\\University\\Third Year\\Fundamentals of Software Testing\\Assignment 2 Workspace\\Assignment2/src/output_uploadAlerts.txt");

root = new _cls_uploadAlerts0();
_cls_uploadAlerts0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_uploadAlerts0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_uploadAlerts0() {
}

public void initialisation() {
}

public static _cls_uploadAlerts0 _get_cls_uploadAlerts0_inst() { synchronized(_cls_uploadAlerts0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_uploadAlerts0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_uploadAlerts0_instances){
_performLogic_alertUploadAndDelete(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_uploadAlerts0[] a = new _cls_uploadAlerts0[1];
synchronized(_cls_uploadAlerts0_instances){
a = _cls_uploadAlerts0_instances.keySet().toArray(a);}
for (_cls_uploadAlerts0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_uploadAlerts0_instances){
_cls_uploadAlerts0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_alertUploadAndDelete = 213;

public void _performLogic_alertUploadAndDelete(String _info, int... _event) {

_cls_uploadAlerts0.pw.println("[alertUploadAndDelete]AUTOMATON::> alertUploadAndDelete("+") STATE::>"+ _string_alertUploadAndDelete(_state_id_alertUploadAndDelete, 0));
_cls_uploadAlerts0.pw.flush();

if (0==1){}
else if (_state_id_alertUploadAndDelete==211){
		if (1==0){}
		else if ((_occurredEvent(_event,370/*unintendedNumberOfAlertsPosted*/))){
		_cls_uploadAlerts0.pw .println ("populatedListOfAlerts -> populatedListOfAlertsContainingUnintendedNumberOfAlerts");

		_state_id_alertUploadAndDelete = 207;//moving to state populatedListOfAlertsContainingUnintendedNumberOfAlerts
		_goto_alertUploadAndDelete(_info);
		}
		else if ((_occurredEvent(_event,372/*intendedNumberOfAlertsPosted*/))){
		_cls_uploadAlerts0.pw .println ("populatedListOfAlerts -> populatedListOfAlertsContainingIntendedNumberOfAlerts");

		_state_id_alertUploadAndDelete = 212;//moving to state populatedListOfAlertsContainingIntendedNumberOfAlerts
		_goto_alertUploadAndDelete(_info);
		}
}
else if (_state_id_alertUploadAndDelete==210){
		if (1==0){}
		else if ((_occurredEvent(_event,366/*unsuccessfullyPostAlerts*/))){
		_cls_uploadAlerts0.pw .println ("emptyListOfAlerts -> emptyListOfAlerts");

		_state_id_alertUploadAndDelete = 210;//moving to state emptyListOfAlerts
		_goto_alertUploadAndDelete(_info);
		}
		else if ((_occurredEvent(_event,368/*successfullyPostAlerts*/))){
		_cls_uploadAlerts0.pw .println ("emptyListOfAlerts -> populatedListOfAlerts");

		_state_id_alertUploadAndDelete = 211;//moving to state populatedListOfAlerts
		_goto_alertUploadAndDelete(_info);
		}
}
else if (_state_id_alertUploadAndDelete==213){
		if (1==0){}
		else if ((_occurredEvent(_event,380/*alertsNotDeleted*/))){
		_cls_uploadAlerts0.pw .println ("viewingAlerts -> unwantedListOfAlerts");

		_state_id_alertUploadAndDelete = 206;//moving to state unwantedListOfAlerts
		_goto_alertUploadAndDelete(_info);
		}
		else if ((_occurredEvent(_event,378/*alertsDeleted*/))){
		_cls_uploadAlerts0.pw .println ("viewingAlerts -> emptyListOfAlerts");

		_state_id_alertUploadAndDelete = 210;//moving to state emptyListOfAlerts
		_goto_alertUploadAndDelete(_info);
		}
}
else if (_state_id_alertUploadAndDelete==212){
		if (1==0){}
		else if ((_occurredEvent(_event,376/*alertsIncorrectlyPosted*/))){
		_cls_uploadAlerts0.pw .println ("populatedListOfAlertsContainingIntendedNumberOfAlerts -> incorrectlyPopulatedListOfAlerts");

		_state_id_alertUploadAndDelete = 208;//moving to state incorrectlyPopulatedListOfAlerts
		_goto_alertUploadAndDelete(_info);
		}
		else if ((_occurredEvent(_event,374/*alertsCorrectlyPosted*/))){
		_cls_uploadAlerts0.pw .println ("populatedListOfAlertsContainingIntendedNumberOfAlerts -> correctlyPopulatedListOfAlerts");

		_state_id_alertUploadAndDelete = 209;//moving to state correctlyPopulatedListOfAlerts
		_goto_alertUploadAndDelete(_info);
		}
}
}

public void _goto_alertUploadAndDelete(String _info){
_cls_uploadAlerts0.pw.println("[alertUploadAndDelete]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_alertUploadAndDelete(_state_id_alertUploadAndDelete, 1));
_cls_uploadAlerts0.pw.flush();
}

public String _string_alertUploadAndDelete(int _state_id, int _mode){
switch(_state_id){
case 208: if (_mode == 0) return "incorrectlyPopulatedListOfAlerts"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  incorrectlyPopulatedListOfAlerts";
case 211: if (_mode == 0) return "populatedListOfAlerts"; else return "populatedListOfAlerts";
case 210: if (_mode == 0) return "emptyListOfAlerts"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  emptyListOfAlerts";
case 213: if (_mode == 0) return "viewingAlerts"; else return "viewingAlerts";
case 206: if (_mode == 0) return "unwantedListOfAlerts"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  unwantedListOfAlerts";
case 207: if (_mode == 0) return "populatedListOfAlertsContainingUnintendedNumberOfAlerts"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  populatedListOfAlertsContainingUnintendedNumberOfAlerts";
case 209: if (_mode == 0) return "correctlyPopulatedListOfAlerts"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  correctlyPopulatedListOfAlerts";
case 212: if (_mode == 0) return "populatedListOfAlertsContainingIntendedNumberOfAlerts"; else return "populatedListOfAlertsContainingIntendedNumberOfAlerts";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}