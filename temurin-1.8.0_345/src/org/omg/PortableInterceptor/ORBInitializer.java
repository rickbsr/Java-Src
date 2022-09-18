package org.omg.PortableInterceptor;


/**
* org/omg/PortableInterceptor/ORBInitializer.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /Users/jenkins/workspace/build-scripts/jobs/jdk8u/jdk8u-mac-x64-temurin/workspace/build/src/corba/src/share/classes/org/omg/PortableInterceptor/Interceptors.idl
* 02 August 2022 11:46:52 o'clock IST
*/


/**
   * Facilitates interceptor registration and ORB initialization.
   * <p>
   * Interceptors are intended to be a means by which ORB services gain 
   * access to ORB processing, effectively becoming part of the ORB. 
   * Since Interceptors are part of the ORB, when <code>ORB.init</code> 
   * returns an ORB, the Interceptors shall have been registered. 
   * Interceptors cannot be registered on an ORB after it has been 
   * returned by a call to <code>ORB.init</code>.
   * <p>
   * An Interceptor is registered by registering an associated 
   * <code>ORBInitializer</code> object which implements the 
   * <code>ORBInitializer</code> interface. When an ORB is initializing, 
   * it shall call each registered <code>ORBInitializer</code>, passing it 
   * an <code>ORBInitInfo</code> object which is used to register its 
   * Interceptor.
   * <p>
   * <b>Registering ORB Initializers in Java</b>
   * <p>
   * ORBInitializers are registered via Java ORB properties.
   * <p>
   * The property names are of the form: 
   *   <blockquote><code>
   *     org.omg.PortableInterceptor.ORBInitializerClass.&lt;Service&gt;
   *   </code></blockquote>
   * where <code>&lt;Service&gt;</code> is the string name of a class 
   * which implements 
   *   <blockquote><code>
   *     org.omg.PortableInterceptor.ORBInitializer
   *   </code></blockquote>
   * To avoid name collisions, the reverse DNS name convention should be 
   * used. For example, if company X has three initializers, it could define 
   * the following properties: 
   * <ul>
   *   <li><code>
   *     org.omg.PortableInterceptor.ORBInitializerClass.com.x.Init1
   *   </code></li>
   *   <li><code>
   *     org.omg.PortableInterceptor.ORBInitializerClass.com.x.Init2
   *   </code></li>
   *   <li><code>
   *     org.omg.PortableInterceptor.ORBInitializerClass.com.x.Init3
   *   </code></li>
   * </ul>
   * During ORB.init, these ORB properties which begin with 
   * <code>org.omg.PortableInterceptor.ORBInitializerClass</code> shall be 
   * collected, the <code>&lt;Service&gt;</code> portion of each property 
   * shall be extracted, an object shall be instantiated with the 
   * <code>&lt;Service&gt;</code> string as its class name, and the 
   * <code>pre_init</code> and <code>post_init</code> methods shall be 
   * called on that object. If there are any exceptions, the ORB shall 
   * ignore them and proceed. 
   * <p>
   * <b><i>Example</i></b>
   * <p>
   * A client-side logging service written by company X, for example, may 
   * have the following ORBInitializer implementation: 
   * <code><pre>
   * package com.x.logging;
   * 
   * import org.omg.PortableInterceptor.Interceptor; 
   * import org.omg.PortableInterceptor.ORBInitializer; 
   * import org.omg.PortableInterceptor.ORBInitInfo; 
   * 
   * public class LoggingService implements ORBInitializer { 
   *     void pre_init( ORBInitInfo info ) { 
   *         // Instantiate the Logging Service s Interceptor. 
   *         Interceptor interceptor = new LoggingInterceptor(); 
   *
   *         // Register the Logging Service s Interceptor. 
   *         info.add_client_request_interceptor( interceptor ); 
   *     } 
   * 
   *     void post_init( ORBInitInfo info ) { 
   *         // This service does not need two init points. 
   *     } 
   * } 
   * </pre></code>
   * To run a program called <code>MyApp</code> using this logging 
   * service, the user could type: 
   *   <blockquote><code>
   *     java 
   *-Dorg.omg.PortableInterceptor.ORBInitializerClass.com.x.Logging.LoggingService 
   *     MyApp
   *   </code></blockquote>
   * <p>
   * <b>Notes about Registering Interceptors</b>
   * <p>
   * Request Interceptors are registered on a per-ORB basis. 
   * <p>
   * To achieve virtual per-object Interceptors, query the policies on the 
   * target from within the interception points to determine whether they 
   * should do any work. 
   * <p>
   * To achieve virtual per-POA Interceptors, instantiate each POA with a 
   * different ORB. While Interceptors may be ordered administratively, 
   * there is no concept of order with respect to the registration of 
   * Interceptors. Request Interceptors are concerned with service contexts. 
   * Service contexts have no order, so there is no purpose for request 
   * Interceptors to have an order. IOR Interceptors are concerned with 
   * tagged components. Tagged components also have no order, so there 
   * is no purpose for IOR Interceptors to have an order. 
   * <p>
   * Registration code should avoid using the ORB (i.e., calling 
   * <code>ORB.init</code> with the provided <code>orb_id</code>). Since 
   * registration occurs during ORB initialization, results of invocations 
   * on this ORB while it is in this state are undefined. 
   * 
   * @see ORBInitInfo
   */
public interface ORBInitializer extends ORBInitializerOperations, org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity 
{
} // interface ORBInitializer
