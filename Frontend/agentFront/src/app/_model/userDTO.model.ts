import { RoleDTO } from './roleDTO.model';

export class UserDTO {
  id: number;
  password: string;
  email: string;
  name: string;
  surname: string;
  address: string;
  city: string;
  state: string;
  phoneNumber: string;
  enabled: boolean;
  company: string;
  roles: Set<RoleDTO>;
}
