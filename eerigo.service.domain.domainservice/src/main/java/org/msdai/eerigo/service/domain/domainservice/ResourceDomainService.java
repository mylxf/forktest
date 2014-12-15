package org.msdai.eerigo.service.domain.domainservice;

import org.msdai.eerigo.core.exception.EerigoRepositoryConcurrentModificationException;
import org.msdai.eerigo.service.domain.model.Resource;
import org.msdai.eerigo.service.domain.repository.ResourceRepository;

/**
 * Created by fengfeng on 14/11/12.
 */
public class ResourceDomainService {
    private ResourceRepository resourceRepository;

    public ResourceDomainService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public boolean addResource(Resource resource){
        try {
            resourceRepository.insert(resource);
            resourceRepository.getContext().commit();
            return true;
        } catch (EerigoRepositoryConcurrentModificationException e) {
            resourceRepository.getContext().rollback();
            return false;
        }
    }

    public boolean removeResource(Resource resource) {
        try {
            resourceRepository.delete(resource);
            resourceRepository.getContext().commit();
            return true;
        } catch (EerigoRepositoryConcurrentModificationException e) {
            resourceRepository.getContext().rollback();
            return false;
        }
    }
}
