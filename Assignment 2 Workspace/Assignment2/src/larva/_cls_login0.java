package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_login0 implements _callable{

public static PrintWriter pw; 
public static _cls_login0 root;

public static LinkedHashMap<_cls_login0,_cls_login0> _cls_login0_instances = new LinkedHashMap<_cls_login0,_cls_login0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\jerem\\Desktop\\University\\Third Year\\Fundamentals of Software Testing\\Assignment 2 Workspace\\Assignment2/src/output_login.txt");

root = new _cls_login0();
_cls_login0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_login0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_login0() {
}

public void initialisation() {
}

public static _cls_login0 _get_cls_login0_inst() { synchronized(_cls_login0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_login0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_login0_instances){
_performLogic_login(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_login0[] a = new _cls_login0[1];
synchronized(_cls_login0_instances){
a = _cls_login0_instances.keySet().toArray(a);}
for (_cls_login0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_login0_instances){
_cls_login0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_login = 70;

public void _performLogic_login(String _info, int... _event) {

_cls_login0.pw.println("[login]AUTOMATON::> login("+") STATE::>"+ _string_login(_state_id_login, 0));
_cls_login0.pw.flush();

if (0==1){}
else if (_state_id_login==66){
		if (1==0){}
		else if ((_occurredEvent(_event,102/*logout*/))){
		_cls_login0.pw .println ("viewingAlerts -> voluntarilyLoggedOut");

		_state_id_login = 67;//moving to state voluntarilyLoggedOut
		_goto_login(_info);
		}
}
else if (_state_id_login==70){
		if (1==0){}
		else if ((_occurredEvent(_event,98/*incorrectLogin*/))){
		_cls_login0.pw .println ("InvoluntarilyLoggedOut -> error401");

		_state_id_login = 68;//moving to state error401
		_goto_login(_info);
		}
		else if ((_occurredEvent(_event,96/*correctLogin*/))){
		_cls_login0.pw .println ("InvoluntarilyLoggedOut -> loggedIn");

		_state_id_login = 69;//moving to state loggedIn
		_goto_login(_info);
		}
}
else if (_state_id_login==69){
		if (1==0){}
		else if ((_occurredEvent(_event,100/*viewAlerts*/))){
		_cls_login0.pw .println ("loggedIn -> viewingAlerts");

		_state_id_login = 66;//moving to state viewingAlerts
		_goto_login(_info);
		}
}
}

public void _goto_login(String _info){
_cls_login0.pw.println("[login]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_login(_state_id_login, 1));
_cls_login0.pw.flush();
}

public String _string_login(int _state_id, int _mode){
switch(_state_id){
case 66: if (_mode == 0) return "viewingAlerts"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  viewingAlerts";
case 69: if (_mode == 0) return "loggedIn"; else return "loggedIn";
case 70: if (_mode == 0) return "InvoluntarilyLoggedOut"; else return "InvoluntarilyLoggedOut";
case 67: if (_mode == 0) return "voluntarilyLoggedOut"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  voluntarilyLoggedOut";
case 68: if (_mode == 0) return "error401"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  error401";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}