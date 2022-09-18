package com.sun.corba.se.PortableActivationIDL;


/**
* com/sun/corba/se/PortableActivationIDL/ServerAlreadyInstalled.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /Users/jenkins/workspace/build-scripts/jobs/jdk8u/jdk8u-mac-x64-temurin/workspace/build/src/corba/src/share/classes/com/sun/corba/se/PortableActivationIDL/activation.idl
* 02 August 2022 11:46:51 o'clock IST
*/

public final class ServerAlreadyInstalled extends org.omg.CORBA.UserException
{
  public String serverId = null;

  public ServerAlreadyInstalled ()
  {
    super(ServerAlreadyInstalledHelper.id());
  } // ctor

  public ServerAlreadyInstalled (String _serverId)
  {
    super(ServerAlreadyInstalledHelper.id());
    serverId = _serverId;
  } // ctor


  public ServerAlreadyInstalled (String $reason, String _serverId)
  {
    super(ServerAlreadyInstalledHelper.id() + "  " + $reason);
    serverId = _serverId;
  } // ctor

} // class ServerAlreadyInstalled
