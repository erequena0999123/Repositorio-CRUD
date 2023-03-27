PGDMP     
    %                {         	   Tecninova    14.1    14.1 $               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16431 	   Tecninova    DATABASE     g   CREATE DATABASE "Tecninova" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE "Tecninova";
                postgres    false            �            1259    16484    cliente_direccion    TABLE     p   CREATE TABLE public.cliente_direccion (
    id_direcciones integer NOT NULL,
    id_cliente integer NOT NULL
);
 %   DROP TABLE public.cliente_direccion;
       public         heap    postgres    false            �            1259    16476    clientes    TABLE     �   CREATE TABLE public.clientes (
    id_cliente integer NOT NULL,
    nombre character varying(1024) NOT NULL,
    apellido character varying(1024) NOT NULL,
    telefono character varying(1024) NOT NULL,
    email text
);
    DROP TABLE public.clientes;
       public         heap    postgres    false            �            1259    16545    clientes_id_cliente_seq    SEQUENCE     �   ALTER TABLE public.clientes ALTER COLUMN id_cliente ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.clientes_id_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    209            �            1259    16492    direcciones    TABLE     �   CREATE TABLE public.direcciones (
    id_direcciones integer NOT NULL,
    ciudad character varying(1024) NOT NULL,
    sector character varying(1024) NOT NULL,
    calle text,
    num_casa text,
    referencia text
);
    DROP TABLE public.direcciones;
       public         heap    postgres    false            �            1259    16500 	   productos    TABLE       CREATE TABLE public.productos (
    id_producto integer NOT NULL,
    id_cliente integer NOT NULL,
    producto character varying(1024) NOT NULL,
    marca character varying(1024) NOT NULL,
    modelo character varying(1024),
    tipo character varying(1024) NOT NULL
);
    DROP TABLE public.productos;
       public         heap    postgres    false            �            1259    16509 	   servicios    TABLE     >  CREATE TABLE public.servicios (
    id_servicio integer NOT NULL,
    id_producto integer,
    id_cliente integer NOT NULL,
    fecha_visita date NOT NULL,
    servicio_realizado text NOT NULL,
    repuesto character varying(1024),
    g_f character varying(1024) NOT NULL,
    meses_garantia character varying(20)
);
    DROP TABLE public.servicios;
       public         heap    postgres    false                      0    16484    cliente_direccion 
   TABLE DATA           G   COPY public.cliente_direccion (id_direcciones, id_cliente) FROM stdin;
    public          postgres    false    210   4,                 0    16476    clientes 
   TABLE DATA           Q   COPY public.clientes (id_cliente, nombre, apellido, telefono, email) FROM stdin;
    public          postgres    false    209   �,                 0    16492    direcciones 
   TABLE DATA           b   COPY public.direcciones (id_direcciones, ciudad, sector, calle, num_casa, referencia) FROM stdin;
    public          postgres    false    211   &2                 0    16500 	   productos 
   TABLE DATA           [   COPY public.productos (id_producto, id_cliente, producto, marca, modelo, tipo) FROM stdin;
    public          postgres    false    212   �7                 0    16509 	   servicios 
   TABLE DATA           �   COPY public.servicios (id_servicio, id_producto, id_cliente, fecha_visita, servicio_realizado, repuesto, g_f, meses_garantia) FROM stdin;
    public          postgres    false    213   �9                  0    0    clientes_id_cliente_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.clientes_id_cliente_seq', 1, false);
          public          postgres    false    214            s           2606    16488 &   cliente_direccion pk_cliente_direccion 
   CONSTRAINT     |   ALTER TABLE ONLY public.cliente_direccion
    ADD CONSTRAINT pk_cliente_direccion PRIMARY KEY (id_direcciones, id_cliente);
 P   ALTER TABLE ONLY public.cliente_direccion DROP CONSTRAINT pk_cliente_direccion;
       public            postgres    false    210    210            n           2606    16482    clientes pk_clientes 
   CONSTRAINT     Z   ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT pk_clientes PRIMARY KEY (id_cliente);
 >   ALTER TABLE ONLY public.clientes DROP CONSTRAINT pk_clientes;
       public            postgres    false    209            v           2606    16498    direcciones pk_direcciones 
   CONSTRAINT     d   ALTER TABLE ONLY public.direcciones
    ADD CONSTRAINT pk_direcciones PRIMARY KEY (id_direcciones);
 D   ALTER TABLE ONLY public.direcciones DROP CONSTRAINT pk_direcciones;
       public            postgres    false    211            y           2606    16506    productos pk_productos 
   CONSTRAINT     ]   ALTER TABLE ONLY public.productos
    ADD CONSTRAINT pk_productos PRIMARY KEY (id_producto);
 @   ALTER TABLE ONLY public.productos DROP CONSTRAINT pk_productos;
       public            postgres    false    212            }           2606    16515    servicios pk_servicios 
   CONSTRAINT     ]   ALTER TABLE ONLY public.servicios
    ADD CONSTRAINT pk_servicios PRIMARY KEY (id_servicio);
 @   ALTER TABLE ONLY public.servicios DROP CONSTRAINT pk_servicios;
       public            postgres    false    213            o           1259    16490    cliente_direccion2_fk    INDEX     Y   CREATE INDEX cliente_direccion2_fk ON public.cliente_direccion USING btree (id_cliente);
 )   DROP INDEX public.cliente_direccion2_fk;
       public            postgres    false    210            p           1259    16491    cliente_direccion_fk    INDEX     \   CREATE INDEX cliente_direccion_fk ON public.cliente_direccion USING btree (id_direcciones);
 (   DROP INDEX public.cliente_direccion_fk;
       public            postgres    false    210            q           1259    16489    cliente_direccion_pk    INDEX     o   CREATE UNIQUE INDEX cliente_direccion_pk ON public.cliente_direccion USING btree (id_direcciones, id_cliente);
 (   DROP INDEX public.cliente_direccion_pk;
       public            postgres    false    210    210            w           1259    16508    cliente_producto_fk    INDEX     O   CREATE INDEX cliente_producto_fk ON public.productos USING btree (id_cliente);
 '   DROP INDEX public.cliente_producto_fk;
       public            postgres    false    212            {           1259    16518    cliente_servicio_fk    INDEX     O   CREATE INDEX cliente_servicio_fk ON public.servicios USING btree (id_cliente);
 '   DROP INDEX public.cliente_servicio_fk;
       public            postgres    false    213            l           1259    16483    clientes_pk    INDEX     M   CREATE UNIQUE INDEX clientes_pk ON public.clientes USING btree (id_cliente);
    DROP INDEX public.clientes_pk;
       public            postgres    false    209            t           1259    16499    direcciones_pk    INDEX     W   CREATE UNIQUE INDEX direcciones_pk ON public.direcciones USING btree (id_direcciones);
 "   DROP INDEX public.direcciones_pk;
       public            postgres    false    211            ~           1259    16517    producto_servicio_fk    INDEX     Q   CREATE INDEX producto_servicio_fk ON public.servicios USING btree (id_producto);
 (   DROP INDEX public.producto_servicio_fk;
       public            postgres    false    213            z           1259    16507    productos_pk    INDEX     P   CREATE UNIQUE INDEX productos_pk ON public.productos USING btree (id_producto);
     DROP INDEX public.productos_pk;
       public            postgres    false    212                       1259    16516    servicios_pk    INDEX     P   CREATE UNIQUE INDEX servicios_pk ON public.servicios USING btree (id_servicio);
     DROP INDEX public.servicios_pk;
       public            postgres    false    213            �           2606    16524 0   cliente_direccion fk_cliente__cliente_d_clientes    FK CONSTRAINT     �   ALTER TABLE ONLY public.cliente_direccion
    ADD CONSTRAINT fk_cliente__cliente_d_clientes FOREIGN KEY (id_cliente) REFERENCES public.clientes(id_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;
 Z   ALTER TABLE ONLY public.cliente_direccion DROP CONSTRAINT fk_cliente__cliente_d_clientes;
       public          postgres    false    210    209    3182            �           2606    16519 0   cliente_direccion fk_cliente__cliente_d_direccio    FK CONSTRAINT     �   ALTER TABLE ONLY public.cliente_direccion
    ADD CONSTRAINT fk_cliente__cliente_d_direccio FOREIGN KEY (id_direcciones) REFERENCES public.direcciones(id_direcciones) ON UPDATE RESTRICT ON DELETE RESTRICT;
 Z   ALTER TABLE ONLY public.cliente_direccion DROP CONSTRAINT fk_cliente__cliente_d_direccio;
       public          postgres    false    3190    211    210            �           2606    16529 (   productos fk_producto_cliente_p_clientes    FK CONSTRAINT     �   ALTER TABLE ONLY public.productos
    ADD CONSTRAINT fk_producto_cliente_p_clientes FOREIGN KEY (id_cliente) REFERENCES public.clientes(id_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;
 R   ALTER TABLE ONLY public.productos DROP CONSTRAINT fk_producto_cliente_p_clientes;
       public          postgres    false    212    209    3182            �           2606    16534 (   servicios fk_servicio_cliente_s_clientes    FK CONSTRAINT     �   ALTER TABLE ONLY public.servicios
    ADD CONSTRAINT fk_servicio_cliente_s_clientes FOREIGN KEY (id_cliente) REFERENCES public.clientes(id_cliente) ON UPDATE RESTRICT ON DELETE RESTRICT;
 R   ALTER TABLE ONLY public.servicios DROP CONSTRAINT fk_servicio_cliente_s_clientes;
       public          postgres    false    3182    213    209            �           2606    16539 (   servicios fk_servicio_producto__producto    FK CONSTRAINT     �   ALTER TABLE ONLY public.servicios
    ADD CONSTRAINT fk_servicio_producto__producto FOREIGN KEY (id_producto) REFERENCES public.productos(id_producto) ON UPDATE RESTRICT ON DELETE RESTRICT;
 R   ALTER TABLE ONLY public.servicios DROP CONSTRAINT fk_servicio_producto__producto;
       public          postgres    false    213    212    3193               �   x��I�A��f�td\�?�m�!���E9nl^\><jA�$ʐ�@�
�h�m�@��Х��/Z���B��.\z�7���~�c�!b�|ʏ�H�A���fr��\�!�]�b��5j6���M�t؍n�����e���#��p(6         8  x�]V�r�6>����v:�!~H�7;����d\����5IP @I%ʭ��c9t�z�. 9�|��]`���^c��/n�߂��Oٶ�1��
&nF���������j�J�J���Q�m�z;��z"��;x����Kw6�dW��1����l�5��%��F�����H�jY�0�����3½٠����-aȧ�>Z��9[����s7��}��R�0�w�ck��u;��v���(N�Kp�YY�GM�ҹ}�a�����9k�ʖ�XG���L��c��Ƚ�:����|0���6L�U]Q�2������G�)�	+���Om8��m]�M�2�A��I��K��S����N�U�x�7�3}���TC/�12��(j�c���X���A[,n����HU1^��?pK�a�C��.~��\�F��I��A�X��_��C+�ZN!X���@�d/Ҭ���j������U,OմM)��n��J�5:y�Ӗ�+Q�RB�L!���.���G�K�;�;,��)l!$�dE,��~t�E@�a��7�U-k*J�t�꺴�?�µF��0P�wy򤬉�: tܰ#^���;�-w��hM�T$|�j�xO�%����D{=P�S{]jGIz ��vw�i4�&���jJ����n����\�8C;n4���bʽ,ES1X����F"�R�.����V-#5Pu�n�%?~���>���p��q&��+Ks������X[r��s����\���������<&���I���rM7d���?M��]�<����4?�8J�Ĩ8-٠?�秗���)�}�I�x�U2S���n�����!���4���]g���,�Z�@%�[����o���ǩ�'t�͸�a���Y�%	���&3P&A���ȟ{�Q۴�YY8��`"\l_0�+Y5�pai��:�|��3,�=F�Oe��@������8N�"6�+c�J�!쿦�)�������)��<"Q��	��T'�Y��(2o��[_PPI��q��<%�ɀ��ן4O4qz�Ⱥ	���&g�ڨtw�s���&%��t�tp"Kbn8�oM�"��Q�a�g�Y!-�e�O�+;l��s��M��Õw_����x���B1�( I=�}2.#C��ڈڳ����	hO_���4Fís�چ�"����<�9	�	W����#�M"%�m7:�{P��>��h������&Y�;	)/)z��M�2t쥞7׹՟� �@��x�J^A\����/I�ָx<M��7�o��-O���'��Ft"�L�K"�ӎ�C6�hy�Y>'��2��������1&         m  x��V=s�6��_�`i��w)�:�K�X���4+��Hh���S\^�"s]Z����$[q4�d&��&����޾e,~�tbL������\�N�+T�,�'�(�)o�W�.I�(ه\��&1�884^eN��[P^o��d��)�ΖjC�(�����By_�Xq��;�1d2M�l�؇�=�HD�}䂬D��bJ6(#*_"�����U��+!>z��d��M��T���R�ykb��`I|
�Ry��,��n�d���'[4�wwr���:1�4�%�{������/�<}����덜Q��%��.��hʀ^������y(·P�������nQ����� ?����)�-CR)@����j*��>��Y$�ڦzMF�U�<c%o5Ч��>�rQ��M^����cS�yZV�2	����T��C����!�7���l5>����$?Q�\�G��*#�	�,u�R����G+N~���F�I���esw8S+���ʓL� �][<.��A=#�Uy�2�+�N���s}�껼pP�g�č��f2����oA$7�~��m�걐��%�,�ճ�^q�wO��+Զ�Wgrd�o�j�\���v��\��\X}���3����!���.;��6�xpT�U���1�Ly�&0��0l�/P_-�s��+��A=?)kU�$�A�JY%���z8o(g�F�?B��� Jɫ�x���gqC3P�B���F0�1�u�=��hh��N�<������J=b[2���3w[�*xPP�v#�V���
����bR�.u&�aN[x�-i �(9�L$���x���y����W��n��M�m� O%���K7�.�ap����9��\e܄��Z��`�Z_�A{%����3��Z��}󨀋�RE�'�+�����Q@�uiZ'��{,G��|�LN�Ƽ%d�׈[m�N�0뵆?�t�v�p,��Z1N	�g�h�+�7�g��GQ���e���gX9���_0p�����>�`4=
x���N5)iM2�W�:r�kͫ�2� ��-�5�o�",5��"_A5a��^ѧ��.gL�r&��&�Z�w��*BǷ_8pj�7OC��r�˥ީm�q7��}����K��wY@������NK�[	gȋY���w�቎���母{h�������6ο�Fids�	������	�N��5����J�.j���9H~Tr"&�FFՎ߲>� 8�C���`AF�u��ꅢv�v�"ۭ7 Ac�Fz�����=v�3�����.ηO ��뉜o~�G_6#�wm������)�'R�fww�6�c��>��Q�C�;�.`5���+��@^�:h�w|����z����*�'���_�Q�	&���           x��U[n�0��Bh!>��v'@v�����,�e���z��*D��0�q�5�\qplL�w�k<�V�c��4~�_��[�|����:����LBbm���?�WK`cw&��J�'SPX�ڶ�ٲ����(C�ߵ�����~ReJ��ɐ�ku�r�X/��@qN�۳�͋s¼K�g�F���_�*T��S��E5�>z[k�932����,�K&�C��ٓw�q ("}�����a�Fwo�1���N�s�x���o�e93D)q��5��k&��a�G�a��Y�BΠ)�i��oum��n�� ±���A��
b�������L!Ӹ
��p��p=���9ؒ��ɥ������ֵcf��䓷���G��x�֦�L搡�7�nw�z�X@�S�хS|�����x�L�
���T
5��C�4%�4^I�p�_.��RE�]����a�ƴd8΀ʠ��P9��y>^7�c��
����SBEo��@���f����6�         �  x��VK��6]7O�(E�ԇ[Ol�T9Y�S���0
�HBI���� Y�t��ߑ⩔oA����(\:�z�lWjw��;l�x��<w��]��P��� i��W�@��7�_��ٺe5�9����(Z��z���\��kP�p>O��]�GS��hͼcn�V�¡g���?�������Е���@��UBf�_���n|"��������������ʘݬ��q��+3�H��iX�h���t23l�������K�Z��ⱔ���)I��m����m��SWӛ� |�(Z"�-�lJ����~����*����:��-�j*�CR�V:���4��� (��p�����^�� P�~wg[��]^j��)�c0���L�!�t��'W��7��9���A 
r
|R���@OX���0�/7w9��Qsw��ڛ��횫-$	�'숓	}Ȩ	϶5(h�5Ԯ����`�5Y���A0�S7꾨�&�ƾ�l��׷���{���Z�0{j���e��B��_'hd� ъc˱���I�S+�����d9% i*��Cz_��b�i�~��I���+�k;�UW�` ){���}}_�h�h�SpGd#�J�>�-�_ij{օ��$Q�Y����I�%�	���9ǩ]M�a�ˑ>�� ��F�a(�Ϯ[;Z0ľ(Ĳ��-�(��0����4�Uyl.曇��+�k�ٺ]�X���B�0x����ݕf X������%��A0�o�ה6 ��-z�+���ͳ�-��Ţ�/tP�����x�R9��(�������o~��9����[�7����W���n(�N��.� �6���)� �O�w#��F��n]eF�����{��-ֳ�Ix��u�g���1j7+������kr�]O�����v �R:_�.�'��	��������pp�	�Jؕ���?3���_�(���=R     