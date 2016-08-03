/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hawkular.listener.bus;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.MessageListener;

import org.hawkular.bus.common.BasicMessage;
import org.hawkular.bus.common.consumer.BasicMessageListener;
import org.jboss.logging.Logger;

/**
 * A listener on HawkularQueue for various Hawkular Events. This is a catch-all listener for consuming relatively
 * infrequent events (high-volume events should have a dedicated Queue or Topic).  This is a Queue listener and
 * as such the messages will be consumed by only one non-deterministic Hawkular server in the cluster.
 *
 * @author Jay Shaughnessy
 */
@MessageDriven(messageListenerInterface = MessageListener.class, activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "HawkularQueue") })
@TransactionAttribute(value = TransactionAttributeType.NOT_SUPPORTED)
public class HawkularQueueListener extends BasicMessageListener<BasicMessage> {
    private final Logger log = Logger.getLogger(HawkularQueueListener.class);

    @Override
    protected void onBasicMessage(BasicMessage msg) {

        //
        // Currently No Messages To Be Handled On This Queue
        //

    }
}
